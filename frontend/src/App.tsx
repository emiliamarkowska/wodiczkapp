import React from 'react';
import {JellyFish_neutral, JellyFish_happy, JellyFish_angry} from './JellyFish/JellyFish';
import './App.css';
import DeviceReckogniser from './components/DeviceReckogniser';


function App() {
  return <DeviceReckogniser/>;
}

export default App;

// import PL from './Lang/PL'


// function App() {
//   return (
//   <div>
//     <div className="ocean">
//       <div className="wave"></div>
//       <div className="wave"></div>
//     </div>
//     <div className="jellyFish">
//     <JellyFish_happy/>
//   </div>
//     <div className="title">
//   <h1>{PL.FIRST_CARD_TITLE}{': 15 litrów wody'}</h1>
//     </div>
//   </div>);