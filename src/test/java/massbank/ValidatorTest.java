/*******************************************************************************
 * Copyright (C) 2025 MassBank consortium
 *
 * This file is part of MassBank.
 *
 * MassBank is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 ******************************************************************************/
package massbank;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void testValidatorCliOnFolder() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp", System.getProperty("java.class.path"),
                "massbank.cli.Validator",
                "src/test/resources/recordfiles"
        );
        pb.redirectErrorStream(true);
        pb.directory(new File(System.getProperty("user.dir")));
        Process process = pb.start();

        String output = new String(process.getInputStream().readAllBytes());
        int exitCode = process.waitFor();

        assertTrue(output.contains("Validator version:"));
        assertEquals(0, exitCode, "Validator sollte mit Exit-Code 0 enden.");
    }

    @Test
    void testValidatorCliOnFile() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp", System.getProperty("java.class.path"),
                "massbank.cli.Validator",
                "src/test/resources/recordfiles/MSBNK-test-TST00001.txt"
        );
        pb.redirectErrorStream(true);
        pb.directory(new File(System.getProperty("user.dir")));
        Process process = pb.start();

        String output = new String(process.getInputStream().readAllBytes());
        int exitCode = process.waitFor();

        assertTrue(output.contains("Validator version:"));
        assertEquals(0, exitCode, "Validator should return 0 on successgit .");
    }

}