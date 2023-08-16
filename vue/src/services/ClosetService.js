import axios from 'axios';

export default {

    getClosetByMascotId(mascotID) {
        return axios.get(`/closet/${mascotID}`)
    },
    updateCloset(closet) {
        return axios.post(`/closet/update/`, closet);
    }
}