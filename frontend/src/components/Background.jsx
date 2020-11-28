import React from 'react';
import {JellyFish_neutral, JellyFish_happy, JellyFish_angry} from '../JellyFish/JellyFish';
import './Background.css';
import './Card2.css'
import Card from './Card';
import SwipeableViews from 'react-swipeable-views';
import greenSeaWeed_1 from '../assets/graphs/greenSeaWeed_1.svg'
import greenSeaWeed_2 from '../assets/graphs/greenSeaWeed_2.svg'
import greenSeaWeed_3 from '../assets/graphs/greenSeaWeed_3.svg'



function Background() {
  return (
      
  <div className="backgroundWrapper">
    <SwipeableViews>
        <Card>
            <div className="jellyFish">
                <JellyFish_happy/>
            </div>
            <h1 className="title">TEST</h1>
        </Card>
        <Card name="card2">
        Karta2
          <div>
        <img className="greenSeaWeed_1"src={greenSeaWeed_1} style={{width:'80px',height:`${50}vh`}}alt="Graph" />
        <img src={greenSeaWeed_2} style={{width:'80px',height: `${50}vh`}}alt="Graph" />
        <img src={greenSeaWeed_3} style={{width:'80px', height: `${90}vh`}}alt="Graph" />
        </div>
        </Card>
        <Card name="card3">
            Karta3
        </Card>
        <Card name="card4">
            Karta4
        </Card>
    </SwipeableViews>
    <div className="ocean">
      <div className="wave"></div>
      <div className="wave"></div>
    </div>
  </div>);
}

export default Background;