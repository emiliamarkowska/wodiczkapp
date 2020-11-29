import React from 'react';
import sandImage from '../assets/backgr/sand.png'
import shirtImage from '../assets/backgr/shirt.png'
import { getDailyUsage } from '../Services/UsageService';
import './InfoTshirtCard.css';

export default class InfoTshirtCard extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      tshirtPercentPerLiter: 1 / 2500. * 100,
      total: 60,
      tshirtPercentUsage: 0
    }
  }

  componentDidMount() {
    getDailyUsage().then(usage => {
      console.log(usage);
      this.setState({
        total: 69,
        tshirtPercentUsage: Math.round((usage.totalDayLiters * this.state.tshirtPercentPerLiter + Number.EPSILON) * 100) / 100,
      });
    });
  }

  render() {
    const { tshirtPercentUsage } = this.state;

    return (
      <div className="usageCard">
        <div className="steel-info-container">
          <div className="steel-info-intro-wrapper">
            <span className="steel-info-intro-text">Twoje dzisiejsze zużycie wody starczyłoby na wyprodukowanie<br/><span className="tshirt-usage-percent">{tshirtPercentUsage}%</span> T-shirta bawełnianego.</span>
            <div className="spacer"/>
          </div>
          <div className="shirt">
            <img src={shirtImage}/>
          </div>
          <div className="steel-info-main-wrapper">
            <div className="spacer"/>
            <span className="steel-info-main-text">Pamiętaj! Również konsumpcjonizm znacząco przykłada się do zużywania zasobów wodnych.<br/>Dbaj o umiar :)</span>
         </div>
        </div>
        <div className="sand">
          <img src={sandImage}/>
        </div>  
      </div>
    );
  }
}