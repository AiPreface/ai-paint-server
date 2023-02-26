import request from '@/utils/request'

// 查询绘图主列表
export function listPaint(query) {
    return request({
        url: '/service/paint/list',
        method: 'get',
        params: query
    })
}

// 查询绘图主详细
export function getPaint(id) {
    return request({
        url: '/service/paint/' + id,
        method: 'get'
    })
}

// 新增绘图主
export function addPaint(data) {
    return request({
        url: '/service/paint',
        method: 'post',
        data: data
    })
}

// 修改绘图主
export function updatePaint(data) {
    return request({
        url: '/service/paint',
        method: 'put',
        data: data
    })
}

// 删除绘图主
export function delPaint(id) {
    return request({
        url: '/service/paint/' + id,
        method: 'delete'
    })
}
