import axios from 'axios';

export default { 
    
    getAllMascotSelector() {
        return axios.get('/mascot_selection');
    },
    getImageForMascotSelector(itemID) {
        return axios.get(`/items_store/${itemID}`)
    },
}