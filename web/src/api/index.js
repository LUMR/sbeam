import axios from 'axios'

const instance = axios.create({
  // baseURL: 'http://192.168.56.102:8080',
  baseURL: 'http://localhost:8080'
})
export default instance
