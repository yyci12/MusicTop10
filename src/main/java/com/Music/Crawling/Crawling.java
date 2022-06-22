package com.Music.Crawling;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.Music.Dto.MusicDto;

public class Crawling {
	public List<MusicDto> Crawling() throws IOException {
		String melon_chart_url = "https://www.melon.com/chart/";
		Document doc;
		ArrayList<String> Title = new ArrayList<>();
		ArrayList<String> listName = new ArrayList<>();
		ArrayList<String> listUrl = new ArrayList<>();
		ArrayList<String> listAlbumTitle = new ArrayList<>();
		ArrayList<String> listAlbumID = new ArrayList<>();

		doc = Jsoup.connect(melon_chart_url).get();

		final Elements rank_list1 = doc.select("div.wrap_song_info div.ellipsis.rank01 span a");
		final Elements rank_list_name = doc.select("div.wrap_song_info div.ellipsis.rank02 span a");

		final Elements image_list1 = doc.select("tr#lst50.lst50 div.wrap a.image_typeAll img");

		final Elements albumtitle_list = doc.select("tr#lst50.lst50 .wrap div.wrap_song_info div.rank03");

		// 앨범 아이디 추출하기
		final Elements albumId_list_1 = doc.select("tr#lst50.lst50 div.wrap a.image_TypeAll");

		for (Element element : rank_list1) {
			Title.add(element.text());
		}
		// 가수정보
		for (Element element : rank_list_name) {
			listName.add(element.text());
		}
		// 이미지정보
		for (Element element : image_list1) {
			listUrl.add(element.attr("src"));
		}
		for (Element element : albumtitle_list) {
			String tmp = element.text();
			listAlbumTitle.add(tmp);
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
		List<MusicDto> list = new ArrayList<MusicDto>();
		for (int i = 0; i < 50; i++) {
			MusicDto MusicDto = new MusicDto();
			MusicDto.setTitle(Title.get(i)); // 곡이름
			MusicDto.setImg(listUrl.get(i)); // img_URL
			MusicDto.setRank(String.valueOf(i + 1)); // 순위
			MusicDto.setArtist(listName.get(i)); // 가수 이름
			MusicDto.setAlbum(listAlbumTitle.get(i));
			MusicDto.setDetail(listAlbumID.get(i)); // 디테일페이지 숫자
			list.add(MusicDto);
		}
		/*
		 * System.out.println(listTitle.get(1)); System.out.println(listUrl.get(1));
		 * System.out.println(String.valueOf(1 + 1));
		 * System.out.println(listName.get(1)); System.out.println(listAlbumID.get(1));
		 */
		return list;
	}

	public List<MusicDto> Crawling2() throws IOException {
		String melon_chart_url = "https://www.melon.com/new/";
		Document doc;
		ArrayList<String> listTitle = new ArrayList<>();
		ArrayList<String> listArtist = new ArrayList<>();
		ArrayList<String> listImage = new ArrayList<>();
		ArrayList<String> detailLink = new ArrayList<>();

		doc = Jsoup.connect(melon_chart_url).get();
		final Elements Title = doc.select("div.wrap_song_info div.ellipsis.rank01 span a");

		final Elements Artist = doc.select("div.wrap_song_info div.ellipsis.rank02 span a");

		final Elements image = doc.select("a.image_typeAll img");

		// 가수정보
		for (Element element : Artist) {
			listArtist.add(element.text());
		}

		for (Element element : Title) {
			listTitle.add(element.text());
		}

		// 이미지정보
		for (Element element : image) {
			listImage.add(element.attr("src"));
		}

		List<MusicDto> list = new ArrayList<MusicDto>();
		for (int i = 0; i < 15; i++) {
			MusicDto BannerDto = new MusicDto();

			BannerDto.setTitle(listTitle.get(i)); // 곡이름
			BannerDto.setImg(listImage.get(i)); // img_URL
			BannerDto.setArtist(listArtist.get(i)); // 가수 이름

			list.add(BannerDto);
		}

		/*
		 * System.out.println(listTitle.get(1)); System.out.println(listUrl.get(1));
		 * System.out.println(listAlbumID.get(1));
		 */

		return list;
	}

	public List<MusicDto> Crawling_bugs() throws IOException {
		String bugs_chart_url = "https://music.bugs.co.kr/chart/track/realtime/total/";
		
		Document doc;
		ArrayList<String> Rank = new ArrayList<>();
		ArrayList<String> listTitle = new ArrayList<>();
		ArrayList<String> listArtist = new ArrayList<>();
		ArrayList<String> listImage = new ArrayList<>();
		ArrayList<String> listAlbum = new ArrayList<>();

		doc = Jsoup.connect(bugs_chart_url).get();
		final Elements RankNo = doc.select("div.ranking");
		// System.out.println(RankNo);
		final Elements image = doc.select(".thumbnail img");
		final Elements Title = doc.select(".byChart .title a");
		final Elements Artist = doc.select(".left .artist");
		final Elements Album = doc.select(".left .album");
		//System.out.println(detail);

		///////////////////////////////////리스트에 저장///////////////////////////////////////
		
		// 랭킹정보
		for (Element element : RankNo) {
			String tmp = element.text();

			String[] result = tmp.split(" ");

			Rank.add(result[0]);
		}
		// 이미지정보
		for (Element element : image) {
			//https://image.bugsm.co.kr/album/images/50/177058/17705802.jpg?version=20220622002632.0
			
			//이미지가 너무 작으니까 리사이징을 해보자
			String tmp = element.attr("src");
			String rep = tmp.replace("/images/50/", "/images/120/");
			System.out.println(rep);
			listImage.add(rep);
		}
		// 아티스트 정보
		for (Element element : Artist) {
			listArtist.add(element.text());
		}
		// 타이틀 정보
		for (Element element : Title) {
			listTitle.add(element.text());
		}
		// 앨범 정보
		for (Element element : Album) {
			listAlbum.add(element.text());
		}

		List<MusicDto> list = new ArrayList<MusicDto>();
		
		for (int i = 0; i < 15; i++) {
			MusicDto BugsDto = new MusicDto();
		
			BugsDto.setTitle(listTitle.get(i)); // 곡이름
			BugsDto.setAlbum(listAlbum.get(i));//앨범이름
			BugsDto.setImg(listImage.get(i)); // img_URL
			BugsDto.setArtist(listArtist.get(i)); // 가수 이름
			BugsDto.setRank(Rank.get(i));
			
			list.add(BugsDto);
		}

		/*
		 * System.out.println(listTitle.get(1)); System.out.println(listUrl.get(1));
		 * System.out.println(listAlbumID.get(1));
		 */

		return list;
	}
	
	public List<MusicDto> Crawling_genie() throws IOException {
		String bugs_chart_url = "https://www.genie.co.kr/chart/top200?ditc=D&ymd=20220622&hh=14&rtm=Y&pg=1";
		
		Document doc;
		ArrayList<String> Rank = new ArrayList<>();
		ArrayList<String> listTitle = new ArrayList<>();
		ArrayList<String> listArtist = new ArrayList<>();
		ArrayList<String> listImage = new ArrayList<>();
		ArrayList<String> listAlbum = new ArrayList<>();

		doc = Jsoup.connect(bugs_chart_url).get();
		final Elements RankNo = doc.select(".list .number");
		//System.out.println(RankNo.text());
		final Elements image = doc.select(".cover img");
		final Elements Title = doc.select(".info .title");
		final Elements Artist = doc.select(".info .artist");
		final Elements Album = doc.select(".info .albumtitle");
		//System.out.println(detail);

		///////////////////////////////////리스트에 저장///////////////////////////////////////
		
		// 랭킹정보
		for (Element element : RankNo) {
			String tmp = element.text();

			String[] result = tmp.split(" ");
			Rank.add(result[0]);
		}
		// 이미지정보
		for (Element element : image) {
			listImage.add(element.attr("src"));
		}
		// 아티스트 정보
		for (Element element : Artist) {
			listArtist.add(element.text());
		}
		// 타이틀 정보
		for (Element element : Title) {
			listTitle.add(element.text());
		}
		// 앨범 정보
		for (Element element : Album) {
			listAlbum.add(element.text());
		}
		/*
		//디테일 페이지 재가공
		for (Element element : detail) {
			//String tmp = element.text();
			detailList.add(element.attr("href"));
			//System.out.println(detailList.toString());
		}
		*/
		
		List<MusicDto> list = new ArrayList<MusicDto>();
		
		for (int i = 0; i < 15; i++) {
			MusicDto BugsDto = new MusicDto();
		
			BugsDto.setTitle(listTitle.get(i)); // 곡이름
			BugsDto.setAlbum(listAlbum.get(i));//앨범이름
			BugsDto.setImg(listImage.get(i)); // img_URL
			BugsDto.setArtist(listArtist.get(i)); // 가수 이름
			BugsDto.setRank(Rank.get(i));
			
			list.add(BugsDto);
		}

		/*
		 * System.out.println(listTitle.get(1)); System.out.println(listUrl.get(1));
		 * System.out.println(listAlbumID.get(1));
		 */

		return list;
	}
}
