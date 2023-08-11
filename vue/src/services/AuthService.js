import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  kidsLogin(kid) {
    return axios.post('/kids/login', kid)
  }

}
