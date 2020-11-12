package cn.nepenthes.miniupload.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页返回结果对象
 * @param <T>
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

    private Long total;
    private Integer totalPage;
    private List<T> items;
}
