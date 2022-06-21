package com.Music.Crawling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.Music.Dto.MusicSoup;

public class Crawling {
	public List<MusicSoup> Crawling() throws IOException {
		String melon_chart_url = "https://www.melon.com/chart/";
		Document doc;
		ArrayList<String> listTitle = new ArrayList<>();
		ArrayList<String> listName = new ArrayList<>();
		ArrayList<String> listUrl = new ArrayList<>();
		ArrayList<String> listAlbumID = new ArrayList<>();

		doc = Jsoup.connect(melon_chart_url).get();
		final Elements rank_list1 = doc.select("div.wrap_song_info div.ellipsis.rank01 span a");
		final Elements rank_list_name = doc.select("div.wrap_song_info div.ellipsis.rank02 span a");

		final Elements image_list1 = doc.select("tr#lst50.lst50 div.wrap a.image_typeAll img");
		// 앨범 아이디 추출하기
		final Elements albumId_list_1 = doc.select("tr#lst50.lst50 div.wrap a.image_TypeAll");
		System.out.println(rank_list1.toString());

		for (Element element : rank_list1) {
			listTitle.add(element.text());
		}
		// 가수정보
		for (Element element : rank_list_name) {
			listName.add(element.text());
		}
		// 이미지정보
		for (Element element : image_list1) {
			listUrl.add(element.attr("src"));
		}

		for (Element element : albumId_list_1) {
			// 앨범 아이디만 나올 수 있도록 문자열 추출 작업
			// <a href="javascript:melon.link.goAlbumDetail('10427559');" 에서 href 속성만 떼어내기
			String tmp = element.attr("href");

			// 그중에서도 앨범 아이디(숫자부분)만 뗴어내기
			int tmp_num = tmp.indexOf("('") + 2;
			String result = tmp.substring(tmp_num, (tmp.substring(tmp_num).indexOf("');") + tmp_num));

			// 앨범 아이디만 리스트에 추가
			listAlbumID.add(result);
		}
		List<MusicSoup> list = new ArrayList<MusicSoup>();
		for (int i = 0; i < 50; i++) {
			MusicSoup MusicDto = new MusicSoup();
			MusicDto.setTitle(listTitle.get(i)); // 곡이름
			MusicDto.setImg(listUrl.get(i)); // img_URL
			MusicDto.setRank(String.valueOf(i + 1)); // 순위
			MusicDto.setArtist(listName.get(i)); // 가수 이름
			MusicDto.setDetail(listAlbumID.get(i)); // 디테일페이지 숫자
			list.add(MusicDto);
		}
		System.out.println(listTitle.get(1));
		System.out.println(listUrl.get(1));
		System.out.println(String.valueOf(1 + 1));
		System.out.println(listName.get(1));
		System.out.println(listAlbumID.get(1));
		
		System.out.println(list);
		return list;
	}

}
