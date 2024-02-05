package controller.productWishList;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.util.Action;
import controller.util.ActionForward;
import model.dao.ProductDAO;
import model.dto.ProductDTO;

public class ProductAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		forward.setPath("productCategory.do");
		forward.setRedirect(false);


		ProductDTO pDTO = new ProductDTO();
		ProductDAO pDAO = new ProductDAO();
		pDTO.setSearchCondition("searchAll");
		ArrayList<ProductDTO> productDatas = new ArrayList<ProductDTO>();
		productDatas = pDAO.selectAll(pDTO);
		request.setAttribute("productDatas", productDatas);
//		ArrayList<ProductDTO> productCategoryDatas = new ArrayList<ProductDTO>();
//		productCategoryDatas = pDAO.selectAllCategory(pDTO);
//		request.setAttribute("productCategoryDatas", productCategoryDatas);
//		System.out.println(productCategoryDatas);
		return forward;
	}
}
