import java.util.Date;


public class Employee {

    private long empno;
    private String ename;
    private String job;
    private Date hiredate;
    private long mgr;
    private long sal;
    private long deptno;

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public long getMgr() {
        return mgr;
    }

    public void setMgr(long mgr) {
        this.mgr = mgr;
    }

    public long getSal() {
        return sal;
    }

    public void setSal(long sal) {
        this.sal = sal;
    }

    public long getDeptno() {
        return deptno;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return empno + " \t"
                + ename + " \t"
                + deptno + " \t"
                + mgr + " \t"
                + sal + " \t"
                + hiredate.toString();
    }
}
