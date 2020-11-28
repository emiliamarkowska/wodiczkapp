import React from 'react';
import {JellyFish_neutral, JellyFish_happy, JellyFish_angry} from '../JellyFish/JellyFish';
import './Background.css';
import Card from './Card';
import SwipeableViews from 'react-swipeable-views';


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