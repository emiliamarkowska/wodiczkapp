import axios from 'axios';

export async function getDailyUsage() {
    return await axios.get('http://10.3.145.165:8080//current-usage/get-usage-for-categories').then(data => data.data);
}