import React from 'react';
import './HistoryCard.css';
import greenSeaWeed_1 from '../assets/graphs/greenSeaWeed_1.svg'
import greenSeaWeed_2 from '../assets/graphs/greenSeaWeed_2.svg'
import greenSeaWeed_3 from '../assets/graphs/greenSeaWeed_3.svg'
import greenSeaWeed_4 from '../assets/graphs/greenSeaWeed_4.svg'
import sandImage from '../assets/backgr/sand.png'
import { getHistoryUsage } from '../Services/UsageService';


export default class HistoryCard extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            imageNumbers: [],
            dailyData: [],
            data: []
        }
    }

    componentDidMount() {
        getHistoryUsage().then((data) => {
            let temp = JSON.parse(JSON.stringify(data.data.days));
            this.setState({
                data: data.data.days
            });

                //calc proportionality
            
            const sorted = temp.sort((a, b) => a.ratio.polandNormal > b.ratio.polandNormal);
            
            let max = sorted[sorted.length - 1].ratio.polandNormal < 1 ? 1 : sorted[sorted.length - 1].ratio.polandNormal;

            temp.forEach(function(item, index) {
                if (!item.ratio.polandNormal) {item.ratio.polandNormal = 0; return;}
                item.ratio.polandNormal = (item.ratio.polandNormal/max);

            })

            const barHeightCalculated = max == 1 ? 100 : (1/max) * 100;

            this.setState({ data: temp, barHeight:barHeightCalculated, propcoeff: 0.8});

            const numbers = []
            for (let i = 0; i < this.state.data.length; i++) {
                numbers.push(Math.floor(Math.random() * 3) + 1);
            }
            this.setState({
                imageNumbers: numbers
            });
        })


    }
    renderBar(){
        return (<div style={{top:`${110-this.state.barHeight}%`}}className="strike">W.U.R</div>)
    }
    getWeedImage(value, id) {
        let seaWeed = greenSeaWeed_1;
        switch(id) {
            case 1:
                seaWeed = greenSeaWeed_1;
                break;
            case 2:
                seaWeed = greenSeaWeed_2;
                break;
            case 3:
                seaWeed = greenSeaWeed_3;
                break;
            case 4:
                seaWeed = greenSeaWeed_4;
                break;
            default:
                seaWeed = greenSeaWeed_1;
                break;
        }
        return (
            <div className="weedWrapper">
                <img src={seaWeed} style={{height: `${value.ratio.polandNormal * 100}%`}}alt="Graph" />
                <div className="weedDate">{new Date(value.date).getDate()}.{new Date(value.date).getMonth() + 1}</div>
            </div>
            
        );
    }

    renderWeeds() {
        const { imageNumbers } = this.state;
        return (this.state.data ? this.state.data.map((value, index) => this.getWeedImage(value, imageNumbers[index])) : null)
    }

    render() {

      return (
        <div className="historyCard">
                {this.renderBar()}
            <div className="weeds">
                {/* <img className="greenSeaWeed_1"src={greenSeaWeed_1} style={{height:`${50}vh`}}alt="Graph" /> */}
                {/* {this.renderBar()} */}
                {this.renderWeeds()}
            </div>
            <div className="sand">
                <img src={sandImage}/>
            </div>  
        </div>
      );
    }
}