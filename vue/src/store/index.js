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
const currentKid = localStorage.getItem('activeKid');


if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    kids: currentKids || [],
    activities: currentActivities || [],
    activeKid: currentKid || {},
    equippedItems: [],
    closetItems: [
      {
        id: 25,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat1.jpg'
      },
      {
        id: 26,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat2.jpg'
      },
      {
        id: 27,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat3.jpg'
      },
      {
        id: 28,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat4.jpg'
      },
      {
        id: 29,
        category: "Hats",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/hats/hat5.jpg'
      },
      {
        id: 1,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt1.jpg'
      },
      {
        id: 2,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt2.jpg'
      },
      {
        id: 3,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt3.jpg'
      },
      {
        id: 4,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt4.jpg'
      },
      {
        id: 5,
        category: "Shirts",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shirts/shirt5.jpg'
      },
      {
        id: 13,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes1.jpg'
      },
      {
        id: 14,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes2.jpg'
      },
      {
        id: 15,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes3.jpg'
      },
      {
        id: 16,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes4.jpg'
      },
      {
        id: 17,
        category: "Shoes",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/shoes/shoes5.jpg'
      },
      {
        id: 37,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc1.jpg'
      },
      {
        id: 38,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc2.jpg'
      },
      {
        id: 39,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc3.jpg'
      },
      {
        id: 40,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc4.jpg'
      },
      {
        id: 41,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc5.jpg'
      },
      {
        id: 42,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc6.jpg'
      },
      {
        id: 43,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc7.jpg'
      },
      {
        id: 44,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc8.jpg'
      },
      {
        id: 45,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc9.jpg'
      },
      {
        id: 46,
        category: "Accessories",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/accessories/acc10.jpg'
      },
      {
        id: 51,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back1.jpg'
      },
      {
        id: 52,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back2.jpg'
      },
      {
        id: 53,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back3.jpg'
      },
      {
        id: 54,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back4.jpg'
      },
      {
        id: 55,
        category: "Backgrounds",
        url: 'https://mykidswellnessapp-media.s3.amazonaws.com/all_items/backgrounds/back5.jpg'
      },
    ],
    equippedMascot:
      {
        mascotSelectionId: 0,
        imgURL: ""
      },
    mascots: [],
  },
  getters: {
    selectedCategory: state => state.selectedCategory
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
        (equippedItem) => {
          // console.log(equippedItem.itemId + ' ' + item.id)
          return (equippedItem.itemId < 13 && item.id < 13) || (equippedItem.itemId >= 13 && equippedItem.itemId < 25 && item.id >= 13 && item.id < 25) || (equippedItem.itemId >= 37 && equippedItem.itemId < 25 && item.id >= 25 && item.id < 37) || (equippedItem.itemId >= 37 && equippedItem.itemId < 51 && item.id >= 37 && item.id < 51) || (equippedItem.itemId >= 51 && item.id >= 51)
        }
      );
      console.log(index)
      if (index !== -1) {
        let dbFriendlyItem = {}
        dbFriendlyItem.itemId = item.id;
        dbFriendlyItem.imgURL = item.url;
        state.equippedItems.splice(index, 1, dbFriendlyItem);
      } else {
        state.equippedItems.push(item);
      }
    },
    EQUIP_MASCOT(state, mascot) {
      state.equippedMascot = mascot;
    },
    SET_SELECTED_CATEGORY(state, category) {
      state.selectedCategory = category;
    },
    SELECT_ITEM(state, item) {
      state.selectedItem = item;
    },
    SET_ACTIVE_KID(state, user) {
      state.activeKid = user;
      localStorage.setItem('kid', user)
    },
    SET_MASCOT_ID(state, id) {
      state.equippedMascot.mascotSelectionId = id
    },
    SET_SELECTED_MASCOT(state, mascot){
      state.equippedMascot = mascot;
    },
    PURCHASE_ITEM(state, purchasedItem) {
      state.closetItems.push(purchasedItem);

      // removes item from items store
      // const index = state.closetItems.findIndex(item => item.itemId === purchasedItem.itemId);
      // if (index !== -1) {
      //   state.closetItems.splice(index, 1);
      // }
    },
    SET_MASCOTS(state, mascotArray) {
      state.mascots = mascotArray
    },
    SET_EQUIPED_ITEMS(state, items) {
      state.equippedItems = items
    }
  },
})
