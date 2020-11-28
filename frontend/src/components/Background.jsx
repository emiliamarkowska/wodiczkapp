import React from 'react';

import './Background.css';
import './Card2.css'
import Card from './Card';
import SwipeableViews from 'react-swipeable-views';
import UsageCard from './UsageCard';
import HistoryCard from './HistoryCard';
import { getDailyUsage } from '../Services/UsageService';
import InfoWaterWalkingCard from './InfoWaterWalkingCard';



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
        //percentageHeight: usage.sum_liters_in_current_hour + '%'
        percentageHeight: 70 + '%'
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
            <Card>
              <HistoryCard/>
            </Card>
            <Card>
              <InfoWaterWalkingCard/>
            </Card>
        </SwipeableViews>
        <div className="ocean" style={{ height: percentageHeight }}>
          <div className="wave"></div>
          <div className="wave"></div>
        </div>
      </div>);
  }

}