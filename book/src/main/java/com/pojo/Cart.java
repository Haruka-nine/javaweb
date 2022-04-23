package com.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {
    private Map<Integer,CartItem> items = new HashMap<Integer, CartItem>();

    /**
     * 添加商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem)
    {
        //先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新
        CartItem item = items.get(cartItem.getId());
        if (item==null)
        {
            items.put(cartItem.getId(),cartItem);
        }
        else
        {
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }


    }

    /**
     * 删除商品
     * @param id
     */
    public void deleteItem(Integer id)
    {
        items.remove(id);

    }

    /**
     * 清空购物车
     */
    public void clear()
    {
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count)
    {
        CartItem item = items.get(id);
        if (item!=null)
        {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }

    }

    public Integer getTotalCount() {
        Integer totalCount=0;
        for (Map.Entry<Integer,CartItem>entry :items.entrySet() )
        {
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry :items.entrySet() )
        {
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
