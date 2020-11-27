import React from 'react';
import {JellyFish_neutral, JellyFish_happy, JellyFish_angry} from './JellyFish/JellyFish';
import './App.css';


function App() {
  return (
  <div>
    <div className="ocean">
      <div className="wave"></div>
      <div className="wave"></div>
    </div>
    <div className="jellyFish">
    <JellyFish_happy/>
  </div>
    <h1 className="title">TEST</h1>
  </div>);
}

export default App;
