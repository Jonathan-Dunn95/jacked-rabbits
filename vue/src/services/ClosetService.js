import axios from 'axios';

export default {

    getItemsByMascotId(mascotID) {
        return axios.get(`/closet/${mascotID}`)
    },
    updateCloset(closet) {
        return axios.post(`/closet/update/`, closet);
    }
}