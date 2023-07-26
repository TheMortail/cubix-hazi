package hu.cubix.spring.gyuri.hr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hr")
public class HrConfigurationProperties {
    private Salary salary;
    public static class Salary{
        private float limit1;
        private float limit2;
        private float limit3;

        public float getLimit1() {
            return limit1;
        }

        public void setLimit1(float limit1) {
            this.limit1 = limit1;
        }

        public float getLimit2() {
            return limit2;
        }

        public void setLimit2(float limit2) {
            this.limit2 = limit2;
        }

        public float getLimit3() {
            return limit3;
        }

        public void setLimit3(float limit3) {
            this.limit3 = limit3;
        }
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
