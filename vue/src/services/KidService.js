import axios from 'axios';

// TODO: Retrieve kids from parents

export default {
    getParents() { 
        return axios.get('/users')
    },
    getKids(parentID) { 
        return axios.get(`/users/${parentID}`)
    },
    getKid(parentID, kidID) { 
        return axios.get(`/users/${parentID}`).then((response) => {
            const kids = response.data.kids;
            return kids.find(kid => kid.id == kidID);
        })
    },
    createKid(kid) {
        return axios.post(`/kids`,kid);
    },
    getActivity(kidID) {
        return axios.get(`/kids/${kidID}/activity`)
    }
}