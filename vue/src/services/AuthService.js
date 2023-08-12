import axios from 'axios';

export default {

  kidsLogin(kid) {
    return axios.post('/login/kids', kid)
  },

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }


}
