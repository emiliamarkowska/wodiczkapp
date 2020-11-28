import React from 'react';
import sandImage from '../assets/backgr/sand.png'
import signImage from '../assets/backgr/sign.png'
import { getDailyUsage } from '../Services/UsageService';
import './InfoWaterWalkingCard.css';

export default class InfoWaterWalkingCard extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      countriesWalkingDist: 6,
      userWalkingDist: 60,
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

  render() {
    const { countriesWalkingDist, userWalkingDist } = this.state;

    return (
      <div className="usageCard">
        <div className="info-container">
          <div className="info-intro-wrapper">
            <div className="spacer"/>
            <span className="info-intro-text">Ludzie w krajach rozwijających się pokonują średnio <span className="countries-info">{countriesWalkingDist}km</span> dziennie,<br/> aby zebrać <span className="countries-info">20l</span> wody.</span>
          </div>
          <div className="info-main-wrapper">
            <span className="info-main-text">Musiał(a)byś przejść <span className="user-dist">{userWalkingDist} km</span>,<nr/> żeby zebrać dziś wodę dla siebie.</span>
            <div className="spacer"/>
         </div>
        </div>
        <div className="spacer"/>
        <div className="sign">
          <div className="sign-content">
            <div className="sign-text">Woda {userWalkingDist}</div>
            <img src={signImage}></img>
          </div>
        </div>
        <div className="sand">
          <img src={sandImage}/>
        </div>  
      </div>
    );
  }
}