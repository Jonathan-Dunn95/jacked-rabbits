import axios from 'axios';

export default { 
    getMascotByKidId(kidID) {
        return axios.get(`/mascot/by-kid/${kidID}`)
    },
    updateMascotById(mascot){
        return axios.put(`/mascot/update/${mascot.mascotId}`, mascot)
    }
}
