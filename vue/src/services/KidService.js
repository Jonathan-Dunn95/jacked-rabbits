import axios from 'axios';

export default {
    getParents() { 
        return axios.get('/users')
    },
    getKids(parentID) { 
        return axios.get(`/users/${parentID}`)
    },
    getKidById(kidID) { 
        return axios.get(`/kids/${kidID}`)
    },
    createKid(kid) {
        return axios.post(`/kids`,kid);
    },
    deleteKid(kidID) {
        return axios.delete(`/kids/${kidID}`)
    },
    getActivity(kidID) {
        return axios.get(`/activity/${kidID}/`)
    },
    getActivities(parentID) {
        return axios.get(`activities/${parentID}`)
    },
    updateActivity(activity) {
        return axios.put(`/activity/update/${activity.kidId}`, activity)
    },
    updateKid(kid) {
        return axios.put(`/kids/update/${kid.id}`, kid);
    }
}