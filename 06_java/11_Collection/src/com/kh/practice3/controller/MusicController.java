package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.practice3.compare.SongAscending;
import com.kh.practice3.model.Music;

public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	
	//1. 특정 곡 추가
	public String addList(String song, String artist) {
		for(Music m : list) {
			if(m.getArtist().equals(artist) && m.getSong().equals(song)) return "추가 실패";
//			if(m.getSong().equals(song)) return "추가 실패";
		}
		
		list.add(new Music(artist,song));
		return "추가 성공";
	}
	
	//2. 전체 곡 목록 출력
	public String printAll() {
		
		return this.list.toString();
	}
	
	//3. 특정 곡 검색
	public ArrayList<String> searchMusic(String keyword) {
		ArrayList<String> musicList = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(keyword) || list.get(i).getArtist().equals(keyword)) {
				musicList.add(String.format("(가수 : %s - 곡 : %s)을 검색했습니다", list.get(i).getArtist(),list.get(i).getSong()));
				
			}
		}
		return musicList;
	}
	
	//4. 특정 곡 수정
	public String updateMusic(String keword, String uSong, String artist, int n) {
		Music music = null;
		int idx = 0;
		int mListIdx = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(keword) || list.get(i).getArtist().equals(keword)) {
				mListIdx++;
				if(mListIdx == n) {
					music = list.get(i);
					idx = i;
					list.remove(i);
					
				}
			}
		}
		for(Music m : list) {
//			if(m.getArtist().equals(artist) && m.getSong().equals(song)) return "추가 실패";
			if(m.getArtist().equals(artist) && m.getSong().equals(uSong) ) {
				list.add(idx,music);
				return "곡을 수정하지 못했습니다.";
			}
		}
		list.add(idx,new Music(artist,uSong));
		return String.format("(%s - %s)의 값이 변경되었습니다.", music.getArtist(), music.getSong());
	}
	
	//5. 특정 곡 삭제
	public String removeMusic(String keword, int n) {
		int mListIdx = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(keword) || list.get(i).getArtist().equals(keword)) {
				mListIdx++;
				if(mListIdx == n) {
					String message = String.format("(가수 : %s - 곡 : %s)을 삭제했습니다.",list.get(i).getArtist(),list.get(i).getSong());
					list.remove(i);
					return message;
				}
			}
		}
		return "삭제할 곡이 없습니다.";
	}
	
	public ArrayList<Music> descArtist() {
		ArrayList<Music> descList = (ArrayList<Music>) list.clone();
		Collections.sort(descList);
//		Collections.reverse(descList);
		return descList;
		
	}
	
	public ArrayList<Music> ascSong() {
		ArrayList<Music> ascList = (ArrayList<Music>) list.clone();
		Collections.sort(ascList,new SongAscending());
		return ascList;
	}
	

	public ArrayList<Music> getList() {
		return list;
	}

	public void setList(ArrayList<Music> list) {
		this.list = list;
	}
	
}