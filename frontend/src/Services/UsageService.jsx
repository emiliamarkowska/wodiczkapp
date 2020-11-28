import axios from 'axios';

export async function getDailyUsage() {
    return await axios.get(`${process.env.REACT_APP_API_BASE_URL}/usage/current-day`).then(data => data.data);
}

export async function getHistoryUsage() {
    return await axios.get(`${process.env.REACT_APP_API_BASE_URL}/usage/days/days_amount/7`).then(data => data);
}