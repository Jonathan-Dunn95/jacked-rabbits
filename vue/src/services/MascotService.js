import axios from 'axios';

export default { 
    getMascotByKidId(kidID) {
        return axios.get(`/mascot/by-kid/${kidID}`)
    }
}