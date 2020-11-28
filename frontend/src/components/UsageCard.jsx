import React from 'react';
import { JellyFish_neutral, JellyFish_happy, JellyFish_angry } from '../JellyFish/JellyFish';
import sandImage from '../assets/backgr/sand.png'
import { getDailyUsage } from '../Services/UsageService';
import './UsageCard.css';

export default class UsageCard extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      total: 0,
      ratio: 0
    }
  }

  componentDidMount() {
    getDailyUsage().then(usage => {
      console.log(usage);
      this.setState({
        total: 69,
        ratio: 0.7 //usage.sum_liters_in_current_hour * 100
      });
    });
  }

  renderJelly() {
    const { ratio } = this.state;
    if (ratio < 0.33) {
      return <div className="jellyFish" style={{opacity: 1}}><JellyFish_happy/></div>;
    } else if (ratio < 0.66) {
      return <div className="jellyFish" style={{opacity: 0.7}}><JellyFish_neutral/></div>;
    } else {
      return <div className="jellyFish" style={{opacity: 0.4}}><JellyFish_angry/></div>;
    }
  }

  render() {
    const { total, ratio } = this.state;

    return (
      <div className="usageCard">
          <div className="spacer"/>
          {this.renderJelly()}
          <h1 className="title-liters">{total} l</h1>
          <h3 className="title-percentage">{ratio*100}%</h3>
          <div className="spacer2"/>
          <div className="sand">
            <img src={sandImage}/>
          </div>  
      </div>
    );
  }
}