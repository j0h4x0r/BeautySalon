package org.beautysalon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
	public static Object login(SendMessage s) {

		BufferedReader br = null;
		Boolean obj;
		String email = s.getEmail();
		String password = s.getPassword();
		try {
			br = new BufferedReader(new FileReader("user.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
				String[] records = line.split("\t");
				if (records[0].equals(email) && records[1].equals(password)) {
					obj = Boolean.valueOf(true);
					br.close();
					return obj;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		obj = Boolean.valueOf(false);
		return obj;
	}

	public static Object getFaceList() {

		BufferedReader br = null;
		GetServiceInfo obj = new GetServiceInfo();
		try {
			br = new BufferedReader(new FileReader("facelist.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
				String[] records = line.split("\t");
				obj.getServiceIdList().add(Integer.valueOf(records[0]));
				obj.getServiceList().add(records[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static Object getFaceDetail(SendMessage s) {

		BufferedReader br = null;
		int id = s.getId();
		FaceInfo obj = new FaceInfo(id);
		try {
			br = new BufferedReader(new FileReader("face" + id + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj.setName(br.readLine());
			obj.setFaceProfile(br.readLine());
			obj.setPrice(Integer.valueOf(br.readLine()));
			obj.setScore(Float.valueOf(br.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static void updateFaceScore(SendMessage s) {

		BufferedReader br = null;
		String content = "";
		int id = s.getId();
		float score = s.getScore();
		try {
			br = new BufferedReader(new FileReader("face" + id + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < 3; i++)
				content += br.readLine() + "\r\n";
			float avg = Float.valueOf(br.readLine());
			int num = Integer.valueOf(br.readLine());
			avg = (avg * num + score) / (num + 1);
			num += 1;
			content += avg + "\r\n" + num + "\r\n";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter("face" + id + ".txt");
			fw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Object getHairList() {

		BufferedReader br = null;
		GetServiceInfo obj = new GetServiceInfo();
		try {
			br = new BufferedReader(new FileReader("hairlist.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
				String[] records = line.split("\t");
				obj.getServiceIdList().add(Integer.valueOf(records[0]));
				obj.getServiceList().add(records[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static Object getHairDetail(SendMessage s) {

		BufferedReader br = null;
		int id = s.getId();
		HairInfo obj = new HairInfo(id);
		try {
			br = new BufferedReader(new FileReader("hair" + id + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj.setHairName(br.readLine());
			obj.setHairProfile(br.readLine());
			obj.setPrice(Integer.valueOf(br.readLine()));
			obj.setScore(Float.valueOf(br.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static void updateHairScore(SendMessage s) {

		BufferedReader br = null;
		String content = "";
		int id = s.getId();
		float score = s.getScore();
		try {
			br = new BufferedReader(new FileReader("hair" + id + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < 3; i++)
				content += br.readLine() + "\r\n";
			float avg = Float.valueOf(br.readLine());
			int num = Integer.valueOf(br.readLine());
			avg = (avg * num + score) / (num + 1);
			num += 1;
			content += avg + "\r\n" + num + "\r\n";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter("hair" + id + ".txt");
			fw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Object getProfile(SendMessage s) {

		BufferedReader br = null;
		String email = s.getEmail();
		UserInfo obj = new UserInfo();
		try {
			br = new BufferedReader(new FileReader(email + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj.setUserId(Integer.valueOf(br.readLine()));
			obj.setUserName(br.readLine());
			obj.setBirthday(br.readLine());
			obj.setRegistTime(br.readLine());
			obj.setPhoneNum(br.readLine());
			obj.setAddress(br.readLine());
			obj.setStaff(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	public static void UpdateUserInfo(SendMessage s) {

		BufferedReader br = null;
		String email = s.getEmail();
		String birthday = s.getUserInfo().getBirthday();
		String phone = s.getUserInfo().getPhoneNum();
		String address = s.getUserInfo().getAddress();
		String content = "";
		try {
			br = new BufferedReader(new FileReader(email + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < 2; i++)
				content += br.readLine() + "\r\n";
			content += birthday + "\r\n";
			br.readLine();
			content += br.readLine() + "\r\n";
			content += phone + "\r\n";
			br.readLine();
			content += address + "\r\n";
			br.readLine();
			content += br.readLine() + "\r\n";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter fw = null;
		try {
			fw = new FileWriter(email + ".txt");
			fw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static Object getRecord(SendMessage s) {

		BufferedReader br = null;
		int id = s.getId();
		List<String> recordTimeAList = new ArrayList<String>();
		List<Integer> recordPriceAlList = new ArrayList<Integer>();
		List<String> recordServiceAlList = new ArrayList<String>();
		List<String> recordStaffAList = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("record" + id + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		try {
			while ((line = br.readLine()) != null) {
				String[] records = line.split("\t");
				recordTimeAList.add(records[0]);
				recordPriceAlList.add(Integer.valueOf(records[1]));
				recordServiceAlList.add(records[2]);
				recordStaffAList.add(records[3]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		RecordInfo obj = new RecordInfo(id, recordTimeAList, recordPriceAlList,
				recordServiceAlList, recordStaffAList);
		return obj;
	}
}
