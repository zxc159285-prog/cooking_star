package com.cooking.star.buylist;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/buylist/*")
public class BuyListController {
	
	@Autowired
	private BuyListService buyListService;

	@GetMapping("/order/complete")
	// 1. Model 대신 RedirectAttributes를 사용합니다.
	public String orderComplete(Principal principal, RedirectAttributes allot) throws Exception {
	    
	    if (principal == null) {
	        return "redirect:/member/login";
	    }
	    
	    String username = principal.getName();
	    BuyListDTO buyListDTO = new BuyListDTO();
	    buyListDTO.setUsername(username);
	    
	    int result = buyListService.setBuyList(buyListDTO);
	    
	    if (result > 0) {
	        // 2. 리다이렉트 시 일회성 메시지 전달 (FlashAttribute)
	        allot.addFlashAttribute("msg", result + "건의 주문이 완료되었습니다.");
	        // 3. /buylist/list 로 바로 이동!
	        return "redirect:/buylist/list"; 
	    } else {
	        allot.addFlashAttribute("msg", "결제할 상품이 없거나 처리에 실패했습니다.");
	        return "redirect:/cart/list"; // 실패 시 장바구니로
	    }
	}

	@GetMapping("list")
	public String getBuyList(Principal principal, Model model) throws Exception {
	    if (principal == null) {
	        return "redirect:/member/login";
	    }

	    BuyListDTO buyListDTO = new BuyListDTO();
	    buyListDTO.setUsername(principal.getName());

	    List<BuyListDTO> list = buyListService.getBuyList(buyListDTO);
	    model.addAttribute("list", list);

	    return "buylist/list"; 
	}
}