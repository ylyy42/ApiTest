package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jdbc.JDBCTemplate;

public class LibDao extends JDBCTemplate {
	private LibDao() {

	}

	private static LibDao instance = new LibDao();

	public static LibDao getInstance() {
		return instance;
	}

	public int delete() {
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " DELETE FROM SEOUL_LIB";

		try {
			con = getConnection();
			pstm = null;
			pstm = con.prepareStatement(sql);

			res = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}

		return res;
	}

	public int insert(List<LibDto> dtos) {
		Connection con = null;
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO SEOUL_LIB(GU_CODE, LIB_SEQ, LIB_NAME, ADDR, TEL, HPG) VALUES(?,?,?,?,?,?)";

		try {
			con = getConnection();
			pstm = con.prepareStatement(sql);

			for (int i = 0; i < dtos.size(); i++) {
				LibDto dto = dtos.get(i);

				pstm.setString(1, dto.getGu_code());
				pstm.setString(2, dto.getLib_seq());
				pstm.setString(3, dto.getLib_name());
				pstm.setString(4, dto.getAddr());
				pstm.setString(5, dto.getAddr());
				pstm.setString(6, dto.getHpg());

				pstm.addBatch();
			}

			int[] result = pstm.executeBatch();

			for (int i = 0; i < result.length; i++) {
				res++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstm);
		}

		return res;
	}

}
