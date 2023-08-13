import axios from 'axios';

export default { 
    
    getAllItems() { 
        return axios.get('/items_store');
    },
    getImage(itemID) { 
        return axios.get(`/items_store/${itemID}`)
    },
}