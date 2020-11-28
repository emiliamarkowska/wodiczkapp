import React from 'react';
import {JellyFish_neutral, JellyFish_happy, JellyFish_angry} from '../JellyFish/JellyFish';
import { getDailyUsage } from '../Services/UsageService';
import './UsageCard.css';

export default class UsageCard extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            currentUsage: 0
        }
    }

    componentDidMount() {
        getDailyUsage().then(usage => {
            console.log(usage);
            this.setState({
                currentUsage: usage.sum_liters_in_current_hour
            });
        });
    }

    render() {
        const { currentUsage } = this.state;

      return (
        <div className="usageCard">
            <div className="jellyFish">
                <JellyFish_happy/>
            </div>
      <h1 className="title">{currentUsage}%</h1>    
        </div>
      );
    }
}