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
function getCategoryFromItemId(itemId) {
  if (itemId >= 1 && itemId <= 12) { 
    return 'Shirts';
  } else if (itemId >= 13 && itemId <= 24) {
    return 'Shoes';
  } else if (itemId >= 25 && itemId <= 36) {
    return 'Hats';
  } else if (itemId >= 37 && itemId <= 48) { 
    return 'Accessories';
  } else { 
    return 'Backgrounds';
  }
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
    ],
    equippedMascot:
      {
        mascotSelectionId: 0,
        imgURL: ""
      },
    mascots: [],
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
      const equippedCategory = getCategoryFromItemId(item.itemId);
      const index = state.equippedItems.findIndex((equippedItem) => {
        const equippedItemCategory = getCategoryFromItemId(equippedItem.itemId);
        return equippedItemCategory === equippedCategory;
      });
      if (index !== -1) {
        state.equippedItems.splice(index, 1, item);
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
      // let storeFriendlyItem = {};
      // storeFriendlyItem.id = purchasedItem.itemId;
      // storeFriendlyItem.url = purchasedItem.imgURL;
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
    },
    SET_CLOSET_ITEMS(state, items) {
      state.closetItems = items;
    }
  },
})
