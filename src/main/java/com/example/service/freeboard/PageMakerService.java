package com.example.service.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.model.Freeboard;
import com.example.pageMaker.PageMaker;

@Service
public class PageMakerService {
	public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard, Long> repository) {
        PageMaker pageMaker = new PageMaker();

        int totalCount = (int) repository.count();
        pageMaker.setTotalCount(totalCount); // ��ü �Խñ� ���� �����Ѵ�.
        pageMaker.setPageNum(pageNum - 1); // ���� �������� ������ ��ü�� �����Ѵ�. -1�� �ؾ� �������� ��� �� �� �ִ�.
        pageMaker.setContentNum(contentNum);// �� �������� ��� �Խñ��� �������� �����Ѵ�.
        pageMaker.setCurrentBlock(pageNum);// ���� ������ ����� �� ������ ���� ������ ��ȣ�� ���ؼ� �����Ѵ�.
        pageMaker.setLastblock(pageMaker.getTotalCount());//������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�.
        pageMaker.prevNext(pageNum); // ���� ������ ��ȣ�� ȭ��ǥ�� ��Ÿ���� ���Ѵ�.
        pageMaker.setStartPage(pageMaker.getCurrentBlock()); // ���� �������� ������ ��� ��ȣ�� ���Ѵ�.
        pageMaker.setEndPage(pageMaker.getLastblock(), pageMaker.getCurrentBlock()); // ������ �������� ������ ������ ��ϰ� ���� ������ ��� ��ȣ�� ���Ѵ�.

        return pageMaker;
    }
}
