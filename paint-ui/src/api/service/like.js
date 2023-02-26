import request from '@/utils/request'

// 查询绘图点赞列表
export function listLike(query) {
    return request({
        url: '/service/like/list',
        method: 'get',
        params: query
    })
}

// 查询绘图点赞详细
export function getLike(id) {
    return request({
        url: '/service/like/' + id,
        method: 'get'
    })
}

// 新增绘图点赞
export function addLike(data) {
    return request({
        url: '/service/like',
        method: 'post',
        data: data
    })
}

// 修改绘图点赞
export function updateLike(data) {
    return request({
        url: '/service/like',
        method: 'put',
        data: data
    })
}

// 删除绘图点赞
export function delLike(id) {
    return request({
        url: '/service/like/' + id,
        method: 'delete'
    })
}
