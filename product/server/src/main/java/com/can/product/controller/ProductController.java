package com.can.product.controller;

import com.can.product.common.DecreaseStockInput;
import com.can.product.VO.ProductInfoVO;
import com.can.product.VO.ProductVO;
import com.can.product.VO.ResultVO;
import com.can.product.dataobject.ProductCategory;
import com.can.product.dataobject.ProductInfo;
import com.can.product.service.CategoryService;
import com.can.product.service.ProductService;
import com.can.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 * @author Chench
 * @date 2018/3/24  10:28
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/lsit")
    public ResultVO<ProductVO> list() {
        //1.查询所有在架的商品
        List<ProductInfo> productInfos = productService.findUpAll();

        //2.获取类目type列表
        List<Integer> categoryList = productInfos.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3.查询类目
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryList);

        //4.构造数据
        List<ProductVO> productVOS = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //将productInfo的属性拷贝到productInfoVO
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    //传统属性赋值方法
    //                productInfoVO.setProductId(productInfo.getProductId());
    //                productInfoVO.setProductName(productInfo.getProductName());
    //                productInfoVO.setProductPrice(productInfo.getProductPrice());
    //                productInfoVO.setProductDescription(productInfo.getProductDescription());
    //                productInfoVO.setProductIcon(productInfo.getProductIcon());
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOS(productInfoVOS);
            productVOS.add(productVO);
        }

        return ResultVOUtil.success(productVOS);
    }

    /**
     * 获取商品列表
     * @param productIds
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIds) {
        return productService.findList(productIds);
    }

    /**
     *
     * @param decreaseStockInputs
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputs) {
        productService.decreaseStock(decreaseStockInputs);
    }
}
