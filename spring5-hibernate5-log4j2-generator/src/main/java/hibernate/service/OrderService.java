package hibernate.service;

import org.springframework.stereotype.Service;

import hibernate.model.Item;

@Service
public class OrderService {

	public void order(String email, Item item, int quantity) {
	}
	
//	  public void insertOrder(Order order) {
//		    for (int i = 0; i < order.getLineItems().size(); i++) {
//		      LineItem lineItem = (LineItem) order.getLineItems().get(i);
//		      String itemId = lineItem.getItemId();
//		      Integer increment = new Integer(lineItem.getQuantity());
//		      Map<String, Object> param = new HashMap<String, Object>(2);
//		      param.put("itemId", itemId);
//		      param.put("increment", increment);
//		      itemMapper.updateInventoryQuantity(param);
//		    }
//
//		    orderMapper.insertOrder(order);
//		    orderMapper.insertOrderStatus(order);
//		    for (int i = 0; i < order.getLineItems().size(); i++) {
//		      LineItem lineItem = (LineItem) order.getLineItems().get(i);
//		      lineItem.setOrderId(order.getOrderId());
//		      lineItemMapper.insertLineItem(lineItem);
//		    }
//		  }
	
//	  public LineItem(@Nonnull final Integer lineNumber, @Nonnull final CartItem cartItem) {
//	        checkNotNull(lineNumber, "Argument[lineNumber] must not be null");
//	        checkNotNull(cartItem, "Argument[cartItem] must not be null");
//	        this.lineNumber = lineNumber;
//	        setItem(cartItem.getItem());
//	        setQuantity(cartItem.getQuantity());
//	    }
	

//    @NamedQuery(name = "Item.updateInventoryQuantity",
//            query = "update item i set i.quantity = i.quantity - :increment where i.itemId = :itemId")
//    @Override
//    public void updateInventoryQuantity(@Nonnull final Map<String, Object> param) {
//        checkNotNull(param, "Argument[param] must not be null");
//        checkState(param.size() == 2,
//                String.format("Argument[param] has illegal state: size[%d]", param.size()));
//        String itemId = (String) param.get(ITEM_ID.toString());
//        Integer increment = (Integer) param.get(INCREMENT.toString());
//
//        Query query = createNamedQuery("Item.updateInventoryQuantity");
//        query.setParameter(ITEM_ID.toString(), itemId);
//        query.setParameter(INCREMENT.toString(), increment);
//        int count = query.executeUpdate();
//        logger.info("Query[Item.updateInventoryQuantity] with parameters[itemId[{}], " +
//                "quantity[{}]] updated with count[{}]", itemId, increment, count);
//    }
}
