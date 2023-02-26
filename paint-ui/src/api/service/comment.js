import request from '@/utils/request'

// 查询绘图评论列表
export function listComment(query) {
    return request({
        url: '/service/comment/list',
        method: 'get',
        params: query
    })
}

// 查询绘图评论详细
export function getComment(id) {
    return request({
        url: '/service/comment/' + id,
        method: 'get'
    })
}

// 新增绘图评论
export function addComment(data) {
    return request({
        url: '/service/comment',
        method: 'post',
        data: data
    })
}

// 修改绘图评论
export function updateComment(data) {
    return request({
        url: '/service/comment',
        method: 'put',
        data: data
    })
}

// 删除绘图评论
export function delComment(id) {
    return request({
        url: '/service/comment/' + id,
        method: 'delete'
    })
}
