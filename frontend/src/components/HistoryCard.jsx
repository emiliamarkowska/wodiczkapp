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
            console.log(data);
            this.setState({
                data: data.days
            });

                //calc proportionality
            const temp = data.days;
            const check = temp.slice();
            let sorted = temp.slice();
            console.log(temp);
            console.log(sorted);
            sorted = sorted.sort((a, b) => (a.ratio.polandNormal > b.ratio.polandNormal) ? 1 : -1)
            const max = sorted[sorted.length - 1].ratio.polandNormal
            console.log(sorted)
            console.log(max)
            temp.forEach(function(item) {
                item.ratio.polandNormal = Math.ceil(item.ratio.polandNormal*100/max);
            })
            this.setState({ data: temp, barHeight:max, propcoeff: 0.8});

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
        console.log(this.state.barHeight*this.state.propcoeff)
        return (<div style={{top:`${100-90}%`}}className="strike">W.U.R</div>)
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
        // console.log(value);
        return (
            <div className="weedWrapper">
<<<<<<< HEAD
                <img src={seaWeed} style={{height: `${value.ratio.polandNormal*this.state.propcoeff}%`}}alt="Graph" />
                <div className="weedDate">{value.localDateTime}</div>
=======
                <img src={seaWeed} style={{height: `${value.percentage}%`}}alt="Graph" />
                <div className="weedDate">{value.date}</div>
>>>>>>> ac34859c15dc29fee89d60e1b2e2e74957fe5000
            </div>
            
        );
    }

    renderWeeds() {
        const { imageNumbers } = this.state;
        console.log(this.state.data);
        return (this.state.data ? this.state.data.map((value, index) => this.getWeedImage(value, imageNumbers[index])) : null)
    }

    render() {
        console.log(this.state.data);

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