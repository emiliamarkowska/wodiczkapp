import React from 'react';

import './Background.css';
import './Card2.css'
import Card from './Card';
import SwipeableViews from 'react-swipeable-views';
import greenSeaWeed_1 from '../assets/graphs/greenSeaWeed_1.svg'
import greenSeaWeed_2 from '../assets/graphs/greenSeaWeed_2.svg'
import greenSeaWeed_3 from '../assets/graphs/greenSeaWeed_3.svg'
import UsageCard from './UsageCard';
import { getDailyUsage } from '../Services/UsageService';



export default class Background extends React.Component {
  constructor(props) {
      super(props);

      this.state = {
          percentageHeight: 0
      }
  }

  componentDidMount() {
    getDailyUsage().then((usage) => {
      this.setState({
        percentageHeight: usage.sum_liters_in_current_hour + '%'
        //percentageHeight: 20 + '%'
      })
    })
  }

  render() {
    const { percentageHeight } = this.state;

    return (
      
      <div className="backgroundWrapper">
        <SwipeableViews>
            <Card>
              <UsageCard/>
            </Card>
            <Card name="card2">
            Karta2
              <div className="weeds">
                <img className="greenSeaWeed_1"src={greenSeaWeed_1} style={{height:`${50}vh`}}alt="Graph" />
                <img src={greenSeaWeed_2} style={{height: `${50}vh`}}alt="Graph" />
                <img src={greenSeaWeed_3} style={{ height: `${90}vh`}}alt="Graph" />
            </div>
            </Card>
            <Card name="card3">
                Karta3
            </Card>
            <Card name="card4">
                Karta4
            </Card>
        </SwipeableViews>
        <div className="ocean" style={{ height: percentageHeight }}>
          <div className="wave"></div>
          <div className="wave"></div>
        </div>
      </div>);
  }

}