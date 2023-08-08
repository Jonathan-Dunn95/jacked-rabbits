import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    //remove this when connecting to DB
    kids: [
      {
        id: 1,
        name: "timmy",
        steps: 0,
        hours: 0,
        carrots: 4
      },
      {
        id: 2,
        name: "jimmy",
        steps: 0,
        hours: 0,
        carrots: 23
      },
      {
        id: 3,
        name: "tommy",
        steps: 0,
        hours: 0,
        carrots: 135
      }
    ]
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    //remove this when connecting to DB
    ADD_KID(state, kid) {
      state.kids.push(kid)
    },
    //remove this when connecting to DB
    DELETE_KID(state,kid) {
      state.kids.splice(state.kids.indexOf(kid),1);
    }
  }
})
