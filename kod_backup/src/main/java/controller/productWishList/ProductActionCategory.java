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

public class ProductActionCategory implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		ActionForward forward = new ActionForward();
		forward.setPath("productRank.do");
		forward.setRedirect(false);


		ProductDTO pDTO = new ProductDTO();
		ProductDAO pDAO = new ProductDAO();
		pDTO.setSearchCondition("category");
		ArrayList<ProductDTO> productCategoryDatas = new ArrayList<ProductDTO>();
		productCategoryDatas = pDAO.selectAll(pDTO);
//		productCategoryDatas = pDAO.selectAllCategory(pDTO);
		request.setAttribute("productCategoryDatas", productCategoryDatas);

		return forward;
	}
}
