import React from 'react';
import './HistoryCard.css';
import greenSeaWeed_1 from '../assets/graphs/greenSeaWeed_1.svg'
import greenSeaWeed_2 from '../assets/graphs/greenSeaWeed_2.svg'
import greenSeaWeed_3 from '../assets/graphs/greenSeaWeed_3.svg'
import greenSeaWeed_4 from '../assets/graphs/greenSeaWeed_4.svg'
import sandImage from '../assets/backgr/sand.png'

// const data = [
//     {
//         key: 1,
//         percentage: Math.floor(Math.random() * 101),
//         date: "2020.11.29"
//     },
//     {
//         key: 2,
//         percentage: Math.floor(Math.random() * 101)
//     },
//     {
//         key: 3,
//         percentage: Math.floor(Math.random() * 101)
//     },
//     {
//         key: 4,
//         percentage: Math.floor(Math.random() * 101)
//     },
//     {
//         key: 5,
//         percentage: Math.floor(Math.random() * 101)
//     },
//     {
//         key: 6,
//         percentage: Math.floor(Math.random() * 101)
//     },
//     {
//         key: 7,
//         percentage: Math.floor(Math.random() * 101)
//     },
// ]



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
        let temp = []
        for (let i = 1; i < 8; ++i) {
            temp.push({
                key: i,
                percentage: Math.floor(Math.random() * 101),
                date: `11.${30 - i}`
            })
        }

        this.setState({ data: temp });

        const numbers = []
        for (let i = 0; i < this.state.data.length; i++) {
            numbers.push(Math.floor(Math.random() * 3) + 1);
        }

        this.setState({
            imageNumbers: numbers
        })
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
        console.log(value);
        return (
            <div className="weedWrapper">
                <img src={seaWeed} style={{height: `${value.percentage}%`}}alt="Graph" />
                <div className="weedDate">{value.date}</div>
            </div>
            
        );
    }

    renderWeeds() {
        const { imageNumbers } = this.state;
        return this.state.data.map((value, index) => this.getWeedImage(value, imageNumbers[index]))
    }

    render() {

      return (
        <div className="historyCard">
            <div className="weeds">
                {/* <img className="greenSeaWeed_1"src={greenSeaWeed_1} style={{height:`${50}vh`}}alt="Graph" /> */}
                {this.renderWeeds()}
            </div>
            <div className="sand">
                <img src={sandImage}/>
            </div>  
        </div>
      );
    }
}