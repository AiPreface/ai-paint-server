import request from '@/utils/request'

// 查询绘图tag列表
export function listTag(query) {
    return request({
        url: '/service/tag/list',
        method: 'get',
        params: query
    })
}

// 查询绘图tag详细
export function getTag(id) {
    return request({
        url: '/service/tag/' + id,
        method: 'get'
    })
}

// 新增绘图tag
export function addTag(data) {
    return request({
        url: '/service/tag',
        method: 'post',
        data: data
    })
}

// 修改绘图tag
export function updateTag(data) {
    return request({
        url: '/service/tag',
        method: 'put',
        data: data
    })
}

// 删除绘图tag
export function delTag(id) {
    return request({
        url: '/service/tag/' + id,
        method: 'delete'
    })
}
