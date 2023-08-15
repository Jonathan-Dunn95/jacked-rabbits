import axios from 'axios';

export default { 
    
    getAllMascotSelector() {
        return axios.get('/mascot_selection');
    },
    getImageForMascotSelector(mascotSelectionID) {
        return axios.get(`/items_store/${mascotSelectionID}`)
    },
    getMascotSelectionByMascotId(mascotSelectionID) {
        return axios.get(`/mascot_selection/select-by-id/${mascotSelectionID}`)
    }
    
}