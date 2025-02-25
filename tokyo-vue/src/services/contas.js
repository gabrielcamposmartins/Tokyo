import axios from 'axios';

const basePath = process.env.VUE_APP_BASE_PATH;

export const getContas = async () => {
    try {
        const response = await axios.get(`${basePath}/conta/all`);
        return response.data;
    } catch (error) {
        console.error('Error fetching contas:', error);
        throw error;
    }
};