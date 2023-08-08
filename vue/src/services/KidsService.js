import axios from 'axios';

export default {

  addKid(kid) {
    return axios.post('/add-kid', kid)
  }

}