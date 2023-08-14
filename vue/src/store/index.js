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
const currentKids = localStorage.getItem('kids');
const currentActivities = localStorage.getItem('activities');

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    kids: currentKids || [],
    activities: currentActivities || [],
    equippedItems: [
      {
        id: 1,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat1.jpg'
      },
      {
        id: 2,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt1.jpg'
      },
      {
        id: 3,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes1.jpg'
      },
      {
        id: 4,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc1.jpg'
      },
      {
        id: 5,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back1.jpg'
      },
    ],
    closetItems: [
      {
        id: 1,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat1.jpg'
      },
      {
        id: 2,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat2.jpg'
      },
      {
        id: 3,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat3.jpg'
      },
      {
        id: 4,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat4.jpg'
      },
      {
        id: 5,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat5.jpg'
      },
      {
        id: 6,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt1.jpg'
      },
      {
        id: 7,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt2.jpg'
      },
      {
        id: 8,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt3.jpg'
      },
      {
        id: 9,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt4.jpg'
      },
      {
        id: 10,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt5.jpg'
      },
      {
        id: 11,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes1.jpg'
      },
      {
        id: 12,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes2.jpg'
      },
      {
        id: 13,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes3.jpg'
      },
      {
        id: 14,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes4.jpg'
      },
      {
        id: 15,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes5.jpg'
      },
      {
        id: 16,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc1.jpg'
      },
      {
        id: 17,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc2.jpg'
      },
      {
        id: 18,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc3.jpg'
      },
      {
        id: 19,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc4.jpg'
      },
      {
        id: 20,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc5.jpg'
      },
      {
        id: 21,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back1.jpg'
      },
      {
        id: 22,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back2.jpg'
      },
      {
        id: 23,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back3.jpg'
      },
      {
        id: 24,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back4.jpg'
      },
      {
        id: 25,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back5.jpg'
      },
    ],
    equippedMascot: [
      {
        id: 11,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot11.jpg"
      },
    ],
    mascots: [
      {
        id: 1,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot1.jpg"
      },
      {
        id: 2,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot2.jpg"
      },
      {
        id: 3,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot3.jpg"
      },
      {
        id: 4,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot4.jpg"
      },
      {
        id: 5,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot5.jpg"
      },
      {
        id: 6,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot6.jpg"
      },
      {
        id: 7,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot7.jpg"
      },
      {
        id: 8,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot8.jpg"
      },
      {
        id: 9,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot9.jpg"
      },
      {
        id: 10,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot10.jpg"
      },
      {
        id: 11,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot11.jpg"
      },
      {
        id: 12,
        url: "https://mykidswellnessapp-media.s3.amazonaws.com/mascots/mascot12.jpg"
      },
    ],
    //remove this when connecting to DB
    // kids: [
    //   {
    //     id: 1,
    //     name: "Timmy",
    //     steps: 0,
    //     minutes: 0,
    //     carrots: 4
    //   },
    //   {
    //     id: 2,
    //     name: "Jimmy",
    //     steps: 0,
    //     minutes: 0,
    //     carrots: 23
    //   },
    //   {
    //     id: 3,
    //     name: "Tommy",
    //     steps: 0,
    //     minutes: 0,
    //     carrots: 135
    //   }
    // ]
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
    },
    SET_KIDS(state,kids) {
      state.kids = kids
      localStorage.setItem('kids', kids)
    },
    SET_ACTIVITIES(state,activties) {
      state.activities = activties
      localStorage.setItem('activities', activties)
    },
    EQUIP_ITEM(state, item) {
      const index = state.equippedItems.findIndex(
        (equippedItem) => equippedItem.category === item.category
      );
  
      if (index !== -1) {
        state.equippedItems.splice(index, 1, item);
      } else {
        state.equippedItems.push(item);
      }
    },
    EQUIP_MASCOT(state, mascot) {
      state.equippedMascot.splice(0, 1, mascot);
    },
  },
})
