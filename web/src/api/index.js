import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://localhost:8081',
  headers: { 'Access-Control-Allow-Methods': 'GET',
    'Access-Control-Allow-Origin': '*:*' }
})
export default instance
